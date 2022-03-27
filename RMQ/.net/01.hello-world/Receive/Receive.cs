using RabbitMQ.Client;
using RabbitMQ.Client.Events;
using System.Text;

var factory = new ConnectionFactory() { HostName = "localhost" }; 
using var connection = factory.CreateConnection();
using var channel = connection.CreateModel();


// the consumer should also create queue, you can ask why so?
// well because we might start the consumer before the publisher, we want
// to make sure that the queue exists before we try to consume messages from it.
channel.QueueDeclare("hello-world-queue",
    durable: false,
    exclusive: false,
    autoDelete: false,
    arguments: null);


var consumer = new EventingBasicConsumer(channel);
consumer.Received += (model, ea) =>
            {
                var body = ea.Body.ToArray();
                var message = Encoding.UTF8.GetString(body);
                Console.WriteLine(message);
            };

channel.BasicConsume(queue: "hello-world-queue",
        autoAck: true,
        consumer: consumer);

Console.ReadLine();