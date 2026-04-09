(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (pickingNumbers [4 6 5 3 3 1])
         3)))

(run-tests)
