(use 'clojure.test)

(load-file "main.clj")

(deftest T
  (is (= (encryption "haveaniceday")
         "hae and via ecy"))

  (is (= (encryption "chillout")
         "clu hlt io")))

(run-tests)
