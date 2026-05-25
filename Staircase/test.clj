(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (staircase 4)
         nil)))

(run-tests)
