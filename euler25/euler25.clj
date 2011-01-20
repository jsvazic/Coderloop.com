(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
    (Integer/parseInt (.trim (.readLine br)))))

(def fib-seq 
  ((fn rfib [a b] 
     (lazy-seq (cons a (rfib b (+ a b)))))
   1 1))

(defn euler25 [len]
  (loop [x 0]
	(if (= (count (str (last (take x fib-seq)))) len) 
	  (int x)
      (recur (inc x)))))

(println (euler25 (process-file (first *command-line-args*))))