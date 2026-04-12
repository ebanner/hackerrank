(use 'clojure.test)

(load-file "main.clj")

(deftest t1
  (is (= (findDigits 124)
         3)))

(deftest t2
  (is (= (findDigits 1012)
         3)))

(run-tests)
