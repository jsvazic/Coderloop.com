(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
      (.trim (.readLine br))))

(defn triangle-num [n]
  (/ (* n (+ n 1)) 2))

(defn num-factors [n]
  (+ 2 (count (for [x (range 2 (/ (+ n 1) 2)) :when (= 0 (mod n x))] [x]))))
	
(defn euler12 [n]
  (first (for [x (range 2 1000000) :when (< n (num-factors (triangle-num x)))] [triangle-num x])))

(println (euler12 (Integer/valueOf (process-file (first *command-line-args*)))))