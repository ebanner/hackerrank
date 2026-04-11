(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (angryProfessor 3 [-1 -3 4 2])
         "YES")))

(run-tests)
