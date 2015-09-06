(def +project+ 'mrmcc3/boot-custom)
(def +version+ "0.1.0-SNAPSHOT")

(set-env!
  :project +project+
  :version +version+
  :source-paths #{"src"}
  :dependencies '[[org.clojure/clojure "1.7.0" :scope "provided"]
                  [boot/core "2.2.0" :scope "provided"]
                  [adzerk/bootlaces "0.1.12" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[mrmcc3.boot-custom :refer :all])

(bootlaces! +version+)

(task-options!
  pom {:project     +project+
       :version     +version+
       :description "Boot task for reloading and invoking a custom function to transform a fileset"
       :url         "https://github.com/mrmcc3/boot-custom"
       :scm         {:url "https://github.com/mrmcc3/boot-custom"}
       :license     {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})
