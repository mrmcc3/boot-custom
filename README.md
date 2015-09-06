# boot-slack 

Boot task for reloading and invoking a custom function to transform a fileset

![Clojars Project](http://clojars.org/mrmcc3/boot-custom/latest-version.svg)

### Usage

in build.boot
```clj
(set-env! :dependencies '[[mrmcc3/boot-custom "0.1.0-SNAPSHOT"]])
(require '[mrmcc3.boot-custom :refer :all])
```

### LICENSE

Copyright © 2015 Michael McClintock

Distributed under the Eclipse Public License, the same as Clojure.
