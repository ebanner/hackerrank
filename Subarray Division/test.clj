(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (birthday [1 2 1 3 2] 3 2)
         2)))

(run-tests)
