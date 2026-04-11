;
; Complete the 'angryProfessor' function below.
;
; The function is expected to return a STRING.
; The function accepts following parameters:
;  1. INTEGER k
;  2. INTEGER_ARRAY a
;

(defn angryProfessor [k a]

  (let [N (count a)
        num-late (count (filter pos? a))
        num-on-time (- N num-late)]

    (if (>= num-on-time k)
      "NO" "YES")))
