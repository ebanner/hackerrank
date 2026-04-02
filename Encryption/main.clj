;
; Complete the 'encryption' function below.
;
; The function is expected to return a STRING.
; The function accepts STRING s as parameter.
;

(require '[clojure.string :as str])

(defmacro defclause [name args pred & body]
  (let [clauses-sym (symbol (str name "-clauses"))]
    `(do
       (def ~clauses-sym (atom []))
       (def ~name
         (fn [& args#]
           (let [clauses# @~clauses-sym]
             (loop [[c# & rest#] clauses#]
               (when-not c#
                 (throw (ex-info "No matching clause" {:args args#})))
               (let [pred# (:pred c#)
                     body# (:body c#)]
                 (if (apply pred# args#)
                   (apply body# args#)
                   (recur rest#)))))))
       (swap! ~clauses-sym
              conj
              {:pred (fn ~(vec args) ~pred)
               :body (fn ~(vec args) ~@body)}))))

(defn subs* [s i width]
  (subs s i (min (+ i width) (count s))))

(defn remove-spaces [s]
  (str/replace s #" " ""))

(defn get-width [s]
  (def n (count s))

  (-> n
      Math/sqrt
      Math/ceil
      long))

(defclause pad [row width] (= (count row) width)
  row)

(defclause pad [row width] true
  (as->
   (- width (count row)) $
   (repeat $ "")
   (into row $)))

(defn get-rows [s width]
  (def n (count s))

  (for [i (range 0 n width)]
    (-> (subs* s i (+ i width))
        vec
        (pad width))))

(defn get-columns [rows]
  (apply map vector rows))

(defn join-columns [columns]
  (->>
   (for [column columns] (apply str column))
   (clojure.string/join " ")))

(defn encryption [s]
  (let [width (get-width (remove-spaces s))
        rows (get-rows (remove-spaces s) width)
        columns (get-columns rows)
        encoded (join-columns columns)]

    encoded))

;; (def s "chillout")

;; (def width (get-width (remove-spaces s)))

;; (def rows (get-rows (remove-spaces s) width))

;; (def columns (get-columns rows))

;; (join-columns columns)

