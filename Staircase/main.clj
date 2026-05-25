;
; Complete the 'staircase' function below.
;
; The function accepts INTEGER n as parameter.
;

(defn serialize [[ns np]]
  (apply str
         (concat (repeat ns " ") (repeat np "#"))))


(defn staircase [n]
  (letfn [(ns [i] (-> (- n i) dec))
          (np [i] (inc i))]

   (->>
    (range n)
    (map #(vector (ns %) (np %)))
    (map serialize)
    (run! println))))
