(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (getMoneySpent [3 1] [5 2 8] 10)
         9)))

(run-tests)
