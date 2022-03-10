; what behavior u will observe
; with an interpreter that uses applicative-
; order evaluation and normal-order
(define (p) (p))
(define (test x y)
  (if (= x 0) 0 y))

(test 0 (p))

; (test 0 (p))
; if (= 0 0) 0 (p))
; >> 0

; that is wrong answer, after running the app
; I am getting the following error message:
; Computation timed out!

; looked into the answers, now I understand why
; in order to evaluate parameter (p) Lisp gets
; into infinite recursion trying to evaluate (p)
; by evaluating (p)

; using applicative-order evaluation, the evaluation of
; (test 0 (p)) never terminates, because (p) is infinely
; expanded to itself:
(test 0 (p))
(test 0 (p))
(test 0 (p))
; .. and so on

; using normal-order evaluation, the expression evaluates,
; step-by-step, to 0:
(test 0 (p))
(if (= 0 0) 0 (p))
(if #true 0 (p))
; >> 0