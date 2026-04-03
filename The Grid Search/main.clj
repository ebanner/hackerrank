;
; Complete the 'gridSearch' function below.
;
; The function is expected to return a STRING.
; The function accepts following parameters:
;  1. STRING_ARRAY G
;  2. STRING_ARRAY P
;

(defn safe-get-in [grid [i j]]
  (when (and (< i (count grid))
             (< j (count (first grid))))

    (get-in coll [i j])))

(defn matches? [G P [row col]]
  (let [n (count P)
        m (count (first P))]

    (every? identity
      (for [i (range n)
            j (range m)]

        (= (safe-get-in G [(+ row i) (+ col j)])
           (safe-get-in P [i j]))))))

(defn gridSearch [G' P']
  (let [G (mapv vec G')
        P (mapv vec P')
        N (count G)
        M (count (first G))]

    (->
     (some identity
       (for [i (range N)
             j (range M)]

         (matches? G P [i j])))

     (if "YES" "NO"))))
