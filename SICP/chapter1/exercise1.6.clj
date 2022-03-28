; we have this defined:
(define (improve guess x)
  (avarage guess (/ x guess)))
  
(define (avarage x y)
  (/ (+ x y) 2))
 
(define  (good-enough? guess x)
  ( < (abs (- (square guess) x)) 0.001))

(define (square x)
  (* x x))

; and new if predicate:
(define (new-if predicate then-clause else-clause)
  (cond (predicate then-clause)
        (else else-clause)))
  
; (new-if (= 3 3) 4 5) >> 4
; (new-if (= 2 3) 0 5) >> 5

; imagine Bob decided to use new-if predicate in our
; square root calculation, explain what happens?
(define (sqrt-iter guess x)
  (new-if (good-enough? guess x)
          guess
          (sqrt-iter (improve guess x) x)))

(sqrt-iter 1.0 4)

; well I was honestly expecting another behavior than what I see on my screen
; I see that now I will get into infinite recursion until stack overflow.
; However I will need to have a look into it a bit later with fresh mind