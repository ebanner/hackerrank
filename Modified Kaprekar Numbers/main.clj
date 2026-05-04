;
; Complete the 'kaprekarNumbers' function below.
;
; The function accepts following parameters:
;  1. INTEGER p
;  2. INTEGER q
;


(defn square [n]
  (* n n))


(defn isKaprekar? [n]
  (let [d (-> (str n) (count))
        N (square n)
        D (-> (str N) (count))
        [l r] [(subs (str N) 0 (- D d)) (subs (str N) (- D d))]]

    (= n
       (+ (if (seq l) (Integer/parseInt l) 0)
          (Integer/parseInt r)))))


(defn fallback [s default]
  (if (seq s) s fallback))


(defn kaprekarNumbers [p q]

  (->
   (range p (inc q))
   (->> (filter isKaprekar?))
   (->> (map str))
   (->> (clojure.string/join " "))
   (fallback "INVALID RANGE")
   (println)))


(kaprekarNumbers 400 700)
