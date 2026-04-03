;
; Complete the 'timeConversion' function below.
;
; The function is expected to return a STRING.
; The function accepts STRING s as parameter.
;

(defn extract [s]
  (let [[hours minutes seconds-mode] (clojure.string/split s #":")
        [seconds mode] [(subs seconds-mode 0 2) (subs seconds-mode 2)]]

    {:hours (Integer/parseInt hours)
     :minutes (Integer/parseInt minutes)
     :seconds (Integer/parseInt seconds)
     :mode mode}))

(defn serialize [hours minutes seconds]
  (format "%02d:%02d:%02d" hours minutes seconds))

(defn convert [hours minutes seconds mode]
  (cond
    (and (= hours 12) (= mode "AM")) [0 minutes seconds]
    (and (= hours 12) (= mode "PM")) [hours minutes seconds]
    (= mode "PM") [(+ hours 12) minutes seconds]
    :else [hours minutes seconds]))

(defn timeConversion [s]
  (let [{:keys [hours minutes seconds mode]} (extract s)]
    (->>
     (convert hours minutes seconds mode)
     (apply serialize))))
