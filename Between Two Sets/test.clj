(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (getTotalX [2 4] [16 32 96])
         3))

  (is (= (getTotalX [1] [100])
         9)))

(run-tests)
