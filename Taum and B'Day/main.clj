;
; Complete the 'taumBday' function below.
;
; The function is expected to return a LONG_INTEGER.
; The function accepts following parameters:
;  1. INTEGER b
;  2. INTEGER w
;  3. INTEGER bc
;  4. INTEGER wc
;  5. INTEGER z
;

(defn taumBday [b w bc wc z]
  (+
   (* b (min (+ wc z) bc))
   (* w (min (+ bc z) wc))))
