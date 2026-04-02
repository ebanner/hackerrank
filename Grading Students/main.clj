;
; Complete the 'gradingStudents' function below.
;
; The function is expected to return an INTEGER_ARRAY.
; The function accepts INTEGER_ARRAY grades as parameter.
;

(defn round [grade]
  (let [remainder (- 5 (mod grade 5))]
    (cond
      (< grade 38) grade
      (<= remainder 2) (+ grade remainder)
      :else grade)))

(defn gradingStudents [grades]
  (for [grade grades] (round grade)))
