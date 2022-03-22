# software engineering at google; lessons learned from people over time
Overall based on the first 50 pages or so this is a really great book, I will give it the second try (decided to read it more focused from laptop while taking notes to revisit in future).  

# why to read it
This book will give you ideas on how things could be done, and a lot of information that you can use to strength your arguments  for adopting best practices like testing, knowleadge sharing, and building collaborative teams. But it does not mean you have to or obligated to follow all the recommentations.  
**It is always about trade offs.**

# programming over time
SE is not just the act of writing code, but all of the **tools** and **processes** an organization uses to **build** and **maintain** that **code over time**.  

software engineering is a programming integrated over time.  

this book emphasizes **three fundamental priniples** to keep in mind when designing, architecting, and writing code:
* Time and Change - how code will need to adapt over the length of its life
* Scale and Growth - how to adapt as it evolves
* Trade-offs nad Costs - make decisions on the lessons of Time and Change & Scale and Growth

# three main aspects of software landscape
* culture
* processes
* tools

## What is SE?
programmer vs computer scientist vs SE  

- skipped for now - wanna read from the middle


## Culture
### how to work well on a team
**It makes sense to begin on focusing on the one variable over which you definitely have control: you**.  

In order to succeed on an engineering team - you need to recognize your behaviors around the core principles of humaniny, **Respect**, and **Trust**.  
#### help me hide my code
**insecurity** - people are afraid of others seeking and judging their work in progress. Recognizing thise theme tipped us off to a more general trend within software development: insecurity is actually a symptom of a larger problem.  
#### the genius myth
The Genius Myth is the tendency that we as humans need to ascribe the success of a team to a single person/leader.  
It turns out that Genius Myth is just another manifestation of our insecurity. Many programmers are afraid to share work they've only just started because it means peers will see their mistakes and know the author of the code is not a genius.  
Common feeling among programmers and the netural reaction is to hide in a cave, work, work, work and than polish, polish, polish.  
##### hiding considered harmful
if you spend all of your time working alone, you are increasing the risk of unnecessary failure and cheating your potential to grow. How do you even know whether you are on the right track?  
**Early detection**. It is easy to make fndamental design mistakes early on; also a risk of reinventing a wheels: **fail early, fail fast, fail often** 
**Bus factor**. The number of people that need to get hit by a bus before your project is completely doomed.  
**Pace of progress**. Compiler analogy, you dont write 1000 lines of code and than compile, you fail and fail fast. You write method, you compile. You add test you compile. The whole DevOps philosophy is all about these sorts of goals: get feedback as early as possible, test as early as possible, and think about security and production environment as early as possible. The earlier we find a problem the cheaper it is to fix it.  

case study: engineers and offices - generally speaking, working alone or remote is as bad as working in the open space (in open spaces people tend to be afraid to speak much not to interrupt other), so the perfect team size per office is 4-8 people.  
**If less-knowleadgeable people on your team feel that there's a barrier to asking you a question, it's a problem: finding the right balance is an art**.  
**In short, don't hide**. wokring alone is much riskier than working with others.
##### its all about the Team
in the realm of programming, lone craftspeople are extremely rare - and even when they do exist, theý don't perform superhuman in a vacum; it is almost always the result of heroic team effort.  
Lets put this idea into simpler words: _software engineering is a team work_.  
##### the three pillars of social interaction
so if the teamwork is the best route of producing great software, how does one build (or find) a great team?  
The foundation on which all healthy interaction and collaboration are based:
* Humility. You are not the center of the universe (or is your code). You are neither omniscient not infallible. You are open to self-improvement.
* Respect. You genuinely care about other you work with. You tream them kindly and appreciate their abilities and accomplishments.
* You believe other are competent and will do the right thing, and you're OK with letting them drive when appropriate.

Do not underestimate the power of playing the social game. It is not about tricking or manipulating people; it's about **creating relationships to get things done**.  
##### humility, respect and trust in practice
**Sometimes the besst thing you can do is just say, "I dont know."**
* lose the ego - noone want to work with someone who consistently behaves like the're the most important person in the room. do you comment on every topic? are you the one who gives last or/and first words on the subject? Think about going for a 'collective' ego instaed - rather than worrying about whether you are personally awesome, try to build a sense of team accomplishment and pride.
* learn to give and take criticism. In a professional software engineering environment, criticism is almost never personal - it's usually just a part of the process of making a better project.
* fail fast and iterate. It is widely recognized that if you are not failing now and then, you are not being innovative enough or taking enough risks.
* learn patience
* be open to influence - the more open you are to influence, the more you are able to influence. Think about coworker who is stubborn - what eventually happens to such team member? People stop listening to their opinions or objections: instead, they end up 'routing around' them like an obstacle everyone takes for granted. 

##### blameless post-mortem culture
The key of learning from mistakes is to document your failures by performing a root-cause analysis and writing up a 'postmortem'. Take extra care to make sure the postmortem document ins't just a useless list of apologies or excuses or finger-pointing.  
A proper post-mortem should always contain an explanation of what was learned and what is going to change as a result of the learning experience.  
A good post-mortem should include the following:
* a brief summary of the event
* a timeline of the event, from discovery through investigation to resolution
* the primary cause of the event
* impact and damage assesment
* a set of action items (with owners) to fix the problem immediately
* a set of action items to prevent the event from happening again
* lessons learned

##### Conclusion
* make progress against the problem, even when the environment is constantly shifting
* has humility to both give and recieve feedbacks; understand how valuable feedback is for personal (and team) development
* is able to set ambitious goals and pursue them even when there might be resistence or inertia from others
* improving team cohesion, actively works to help coworkers without being asked
* has a strong sense of etics about everything they do; willing to make a difficult or inconvinient decisions to protect the integrity of the team and product