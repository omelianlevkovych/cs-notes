# building abstractions with procedures
We are about to study the idea of a **computational process**.  
As they evolve (computers), processes manipulate other abstract thigs called **data**.  

Def: The evolution of a process is directed by a pattern of rules called a **program**.  
People create programs to direct (manipulate) processes.  

A computational process is indeed much like a spirit. It cannot be touched or seen. It is not composed of any matter at all. However, it is very real. It can perform intelectual work. It can answer questions.  

(Hah it remind me old good times from rational and hpmor):
Thus, like the sorcerer's apprentice, novice programmers must learn to understand and to anticipate the consequences of their conjuring. Even small errors (usually called bugs or glitches) in programs can have complex and unanticipated consequences.  

Well designed computational systems, like well-designed automobiles or nuclear reactors, are designed in a **modular manner**, so that the parts can be constructed, replaced, and debugged separetly.  

## 1.1 the elements of programming
When we describe a language we should pay particular attention to the means(methods) that the language provides for combining simple ideas to form more complex ideas.  
Every programming language has three mechanisms for accomplishing this:
*  **primitive expressions**, which represent the simplest entities the language is concerned with,
*  **means of combination**, by which compound elements are built from simple ones, and
*  **means of abstraction**, by which compound elements can be named and manipulated as units.  

In programming we deal with two kinds of elements: **procedures** and **data**. (later on we will see that they are really not so distinct).  

In this chapter we will deal only with the simple numerical data so that we can focus on the rules for building procedures.

## 1.1.1 expressions
https://inst.eecs.berkeley.edu/~cs61a/fa14/assets/interpreter/scheme.html

```sh
(+ 8 4)
>> 12
```
The convention of placing the operator to the left of the operands is known as _prefix notation_. Prefix notations has several advantages:
* it can accommodate procedures that may take an arbitrary number of arguments, eg
```sh
(+ 8 4 -5 314 0)
>> 321
```
* it extends in a straightforward way to allow combinations to be nested, eg
```sh
(+ (* 3 7) (- 10 12))
>> 19
```

Tip: use pretty-prining, page 37

## 1.1.2 naming and the environment
In the Scheme dialect of Lisp, we name things with **define**.  
```sh
(define size 2)
```
causes the interpreter to associate the value 2 with the name _size_. Once the name _size_ has been associated with the number 2, we can refer to the value 2 by name:
```sh
size 2
>> 2
```

**define** is our language's simplest means of abstraction, for it allows us to use simple names to refer to the results of compound operations, such as the _circumference_ eg:
```sh
(define pi 3.14)
(define radius 10)
(define circumference (* 2 pi radius))
circumference
>> 62.800000000000004
```

In general, computational objects may have very complex structures, and it would be extremely hard to have to remember and repeat their details each time we want to use them.  
Indeed, complex programs are constructed by building, step by step, computational objects of increasing complexity.  

It should be clear that the possibility of associating values with symbols and later retrieving them means that the interpreter must maintain some sort of memory that keeps track of the name-object pairs. This memory is called the **environment**.  

http://www.uponmyshoulder.com/blog/2011/so-you-want-to-do-the-sicp/


# 1/1/4 compound procedures
The general form of procedure definition:
```sh
(define (<name> <formal parameters>)
<body>)
```
example: x^2 + y^2
```sh
(define (square x)(* x x))

(define (sum-of-squares x y)
(+ (square x)(square y)))
```

# the substitution model for procedure application
The substitution model is only the first of many possible models - a way to get started thinking formally about the evaluation process. In general, when modeling phenomena in science and engineering, we begin with simplified, incomplete models. As we grow, as we examine things in greater detail, this simple models become inadequate and must be replaced by more refined models.

### applicable order versus normal order
The interpreter first evaluates the operator and operands and then applies the resulting procedure to the resulting arguments. This is not the only way to perform evaluation. An alternative evaluation model would not evaluate the operands until their values were needed. Instead it will only evaluate when only primitive operands are used.  
List uses applicative-order
