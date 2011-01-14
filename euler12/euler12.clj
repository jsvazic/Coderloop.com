(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
      (.trim (.readLine br))))

(defn triangle-num [n]
  (/ (* n (+ n 1)) 2))

(defn sieve [n]
  (let [n (int n)]
    (let [root (int (Math/round (Math/floor (Math/sqrt n))))]
      (loop [i (int 3)
             a (int-array n)
             result (list 2)]
        (if (>= i n)
          (reverse result)
          (recur (+ i (int 2))
                 (if (< i root)
                   (loop [arr a
                          inc (+ i i)
                          j (* i i)]
                     (if (>= j n)
                       arr
                       (recur (do (aset arr j (int 1)) arr)
                              inc
                              (+ j inc))))
                   a)
                 (if (zero? (aget a i))
                   (conj result i)
                   result)))))))

(defn prime-factor-count [my-num factor]
  (loop [exp 1]
    (if (not= 0 (mod my-num (int (Math/pow factor exp))))
	  (dec exp)
	  (recur (inc exp)))))
	  
(defn factor-count [t-num min-factors]
  (let [prime-factors (filter #(and (= 0 (mod t-num %)) (<= % t-num)) (sieve min-factors))]
	(reduce * (map #(+ 1 (prime-factor-count t-num %)) prime-factors))))

(defn euler12 [min-factors]
  	(loop [curr 2 f-count 2]
	  (if (> f-count min-factors)
	    (triangle-num curr)
	    (recur (inc curr) (factor-count (triangle-num (+ 1 curr)) min-factors)))))
		
(println (euler12 (Integer/valueOf (process-file (first *command-line-args*)))))