(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (taumBday 10 10 1 1 1)
         20)))

(run-tests)
