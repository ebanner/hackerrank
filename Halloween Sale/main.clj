;
; Complete the 'howManyGames' function below.
;
; The function is expected to return an INTEGER.
; The function accepts following parameters:
;  1. INTEGER p
;  2. INTEGER d
;  3. INTEGER m
;  4. INTEGER s
;


(defn howManyGames [p d m s]
  (letfn [(f [p s]
            (if (< s p)
              0
              (inc (f (max (- p d) m) (- s p)))))]

    (f p s)))
