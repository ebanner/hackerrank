;
; Complete the 'birthday' function below.
;
; The function is expected to return an INTEGER.
; The function accepts following parameters:
;  1. INTEGER_ARRAY s
;  2. INTEGER d
;  3. INTEGER m
;

(defn ++ [a b]
  (+ (if a 1 0) (if b 1 0)))

(defn birthday [S d m]
  (def N (count S))

  (reduce ++
   (for [i (range (- N m 1))]
     (let [window (subvec S i (+ i m))]
       (= (reduce + window) d)))))
