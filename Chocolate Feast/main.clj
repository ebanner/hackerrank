;
; Complete the 'chocolateFeast' function below.
;
; The function is expected to return an INTEGER.
; The function accepts following parameters:
;  1. INTEGER n
;  2. INTEGER c
;  3. INTEGER m
;

(defn chocolateFeast [n c m]

  (letfn [(loop [n w]
            (cond
              (>= n c) (inc (loop (- n c) (inc w)))
              (>= w m) (inc (loop n (-> (- w m) inc)))
              :else 0))]

    (loop n 0)))
