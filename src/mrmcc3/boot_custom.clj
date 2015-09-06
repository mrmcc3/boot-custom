(ns mrmcc3.boot-custom
  (:require [boot.core :refer :all]
            [boot.util :refer [info tmpfileset?]]
            [clojure.java.io :as io]))

(deftask custom
  "reload and invoke a function passing the fileset, a temp dir and optional data.
  if a fileset is returned it will be committed. Otherwise the temp dir will be added
  as a resource to the fileset which is then committed."
  [f custom-fn SYM sym "custom function to invoke"
   d data {kw edn} "additional data"]
  (let [tmp (tmp-dir!)]
    (with-pre-wrap fileset
      (empty-dir! tmp)
      (info "\nRunning custom task...\n")
      (require (-> custom-fn namespace symbol) :reload-all)
      (let [out ((resolve custom-fn) fileset tmp data)]
        (if (tmpfileset? out)
          (commit! out)
          (-> fileset (add-resource tmp) commit!))))))

(defn spit-to
  "helper function for spitting to a path in a directory"
  [dir path contents]
  (let [f (io/file dir path)]
    (info "• %s\n" path)
    (io/make-parents f)
    (spit f contents)))

(defn slurp-from [fileset path]
  "helper function for slurping from a path in the fileset"
  (-> fileset (tmp-get path) tmp-file slurp))

