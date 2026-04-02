;
; Complete the 'kangaroo' function below.
;
; The function is expected to return a STRING.
; The function accepts following parameters:
;  1. INTEGER x1
;  2. INTEGER v1
;  3. INTEGER x2
;  4. INTEGER v2
;

(defn kangaroo [x1 v1 x2 v2]
  (if (>= v2 v1)
    "NO"
    (loop [x1 x1
           x2 x2]

      (cond
        (= x1 x2) "YES"
        (> x1 x2) "NO"
        :else (recur (+ x1 v1) (+ x2 v2))))))
