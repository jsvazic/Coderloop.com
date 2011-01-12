(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
      (.trim (.readLine br))))

(defn triangle-num [n]
  (/ (* n (+ n 1)) 2))

(defn factors [n]
  (for [x (range 2 (/ (+ n 1) 2)) :when (= 0 (mod n x))] [x]))
	
(println (factors 100))
  
;(def my-pow (Integer/valueOf (process-file (first *command-line-args*))))