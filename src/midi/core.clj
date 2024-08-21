(ns midi.core
  (:gen-class))

(defn slurp-bytes [fname]
  (with-open [in (clojure.java.io/input-stream fname)
              out (java.io.ByteArrayOutputStream.)]
    (clojure.java.io/copy in out)
    (.toByteArray out)))

(defn b->i [b]
  (bigint (byte-array b)))

(defn i-length [ba]
  (let [i (take 4 (drop 4 ba))]
    (b->i i)))

(defn get-i [ba]
  (let [r (drop 8 ba)
        l (i-length ba)]
    [(take l r) (drop l r)])) ;we want to recur this on last vector item until we have chunked the whole array

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
