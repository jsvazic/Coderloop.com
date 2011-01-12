(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
      (.trim (.readLine br))))

(defn triangle-num [n]
  (/ (* n (+ n 1)) 2))

; We're counting 1 and n already as factors, hence the reason we add 2 to the count.
(defn num-factors [n]
  (+ 2 (count (for [x (range 2 (/ (+ n 1) 2)) :when (= 0 (mod n x))] [x]))))
	
(println (num-factors 100))
  
;(def my-pow (Integer/valueOf (process-file (first *command-line-args*))))