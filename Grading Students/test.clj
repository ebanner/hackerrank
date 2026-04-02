(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (gradingStudents [73 67 38 33])
         [75 67 40 33])))

(run-tests)
