; observe that our model of evaluation allows
; for combinations whose operators are compound
; expressions.
; use this observation to describe the behavior
; of the following procedure:
(define (a-plus-abs-b a b)
  ((if (> b 0) + -) a b ))

; procedure/function naming gives a hint
; I am a bit impressed actually that u can
; do something like this in Lisp, cool
(a-plus-abs-b -3 -1)
; >> -2