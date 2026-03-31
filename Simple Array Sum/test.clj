(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (simpleArraySum [1 2 3 4 10 11])
         31)))

(run-tests)
