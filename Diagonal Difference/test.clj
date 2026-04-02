(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (let [grid [[11 2 4]
              [4 5 6]
              [10 8 -12]]]

    (is (= (diagonalDifference grid)
           15))))

(run-tests)
