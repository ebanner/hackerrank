(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (beautifulDays 20 23 6)
         2)))

(run-tests)
