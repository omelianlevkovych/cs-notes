; define a procedure that takes three numbers
; as arguments and returns the sum of the squares
; of the two larger numbers

(define (square x) (* x x))
(define (sqrt-sum x y) 
  (+ (square x) (square y)))

(define (f x y z)
  (cond ((and (< x y) (< x z)) (sqrt-sum y z))
        ((and (< y x) (< y z)) (sqrt-sum x z))
        ((and (< z y) (< z x)) (sqrt-sum x y))))

(f 1 2 3)

; >> 13