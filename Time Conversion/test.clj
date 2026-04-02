(use 'clojure.test)

(load-file "main.clj")

(deftest t1
  (is (= (timeConversion "07:05:45PM")
         "19:05:45")))

(deftest t2
  (is (= (timeConversion "12:40:22AM")
         "00:40:22")))

(deftest t3
  (is (= (timeConversion "12:45:54PM")
         "12:45:54")))

(run-tests)
