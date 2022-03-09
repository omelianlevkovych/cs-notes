; below is a sequence of expressions. What is the result
; printed by the interpreter in response to each expression?
; assume that the sequence is to be evaluated in the order which
; it is presented.

10
; >> 10

(+ 5 3 4)
; >> 12

(- 9 1)
; >> 8

(/ 6 2)
; >> 3

(+ (* 2 4) (- 4 6))
; >> 6

(define a 3)
(define b (+ a 1))

; next one is funny, I have got caught here a bit
; I just forgot that u can have many arguments after operator
(+ a b (* a b))
; >> 19

(= a b)
; >> false

(if (and (> b a)(< b (* a b)))
    b
    a)
; >> 4

(cond ((= a 4) 6)
      ((= b 4) (+ 6 7 a))
      (else 25))
; >> 16

; here I made a mistake, I was expecting to have 9 as a result
; thats because I didn't understand the if structure condition well:
; so here we go (if <predicate> <consequent> <alternative>) 
(+ 2 (if (> b a) b a))
; >> 6

(* (cond ((> a b) a)
         ((< a b) b)
         (else -1))
   (+ a 1))
; >> 16