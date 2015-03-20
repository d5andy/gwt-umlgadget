# gwt-uml #
## Text to UML Diagram Wave gadget ##
A UML gadget based on [ModSL](http://code.google.com/p/modsl/) which allows users to draw UML diagrams in Wave using the [ModSL](http://code.google.com/p/modsl/) syntax for UML.

This project also makes use of several open source GWT projects:
  * [cobogwave](https://code.google.com/p/cobogwave/).
  * [gwt-g2d](https://code.google.com/p/gwt-g2d/).
  * [gwtx](https://code.google.com/p/gwtx/).
  * [gwt-log](https://code.google.com/p/gwt-log/).

Also makes extensive use of the google apis for Wave Gadgets and GWT.

(This conversion allows the application hosted by google app engine)

## How-to use: ##

The project is intended to be used in Google Wave and renders UML diagrams based on the text entered either into the Wave or directly into the Gadget.

A guide to the text based UML syntax can be found [here](http://code.google.com/p/modsl/wiki/LanguageSyntax).

The Wave Gadget is currently hosted on Google Appengine at: http://umlgadget.appspot.com
The Wave Robot is currently hosted on Google Appending at: http://umlgraphrobot.appspot.com/umlapplication/umlGraphService

### Use the Robot ###
  1. Add the address "umlgraphrobot@appspot.com" as a contact
  1. Add the contact to your wave
  1. `#!UML` triggers the robot into action - inserts the gadget and passes the text to the gadget to parse and render

### Use the Gadget ###
  1. Click into the wavelet then select "add gadget" from the wavelet tool bar.
  1. Enter the gadget [url](http://umlgadget.appspot.com)
  1. Once the gadget is initialised right click on the gadget area and "Edit ModSL UML" add your UML text.
  1. **Alternatively** use the [extension installer](http://umlgadget.appspot.com/manifest.xml) to add a link to the toolbar directly to the gadget.

## How-to Build ##
  1. Run `mvn install` at the root level.
  1. Import into Eclipse as **Maven** projects (use the [maven plugin](http://m2eclipse.sonatype.org/update/)
  1. From their you can configure the appengine settings and deploy to your preferred env.
  1. If you wish to view the gadget in the google sandbox run `uml-application/mvn install gwt:run`

### Gotchas ###
  1. remove the gwt-dev jar from the war/lib folder before deployment to appengine
  1. copy the gwt-log jar to the war/lib folder



## Thanks to ##
**`gwt-gadget`** is based on **`ModSL`** project, so thanks to the project and its team.