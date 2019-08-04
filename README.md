# gef5.mvc.examples
I want to make an Eclipse Graphical Editor with GEF5.

I am trying to migrate GEF3 Editor of [TMD-Maker](https://github.com/tmdmaker/tmdmaker) to GEF5.

## These examples require the follwing.
- Java11
- Eclipse 2019-06
- e(fx)clipse
  - Install from marketplace or udatesite.
- OpenJFX11
  1. Download OpenJFX11 from [here](https://openjfx.io/index.html).
  2. Create a new User Library under Eclipse -> Window -> Preferences -> Java -> Build Path -> User Libraries -> New. And Named it JavaFX11 and include the jars under the lib folder from JavaFX 11.
- Import examples and click "Set as Active Target Platform" of tmdmaker.ui.editor.targetplatform/tmdmaker.ui.editor.target.

Example 1
=========

Minimal GEF5 Eclipse Graphical Editor.

Example 2
=========

Manage multiple models.

Example 3
=========

Move the model using the mouse.

Example 4
=========
Undo/Redo.

Example 5
=========

Add/Remove.

Example 6(Now trying)
=========
Create connection.

Future Ideas
==========

* Zoom/Scroll/FitToViewportLock

* Resize

* Context menu

* ContentOutlinePage

* PropertySheet

* Reconnect

Thanks to

- https://info.itemis.com/en/gef/tutorials/

- https://github.com/frankbenoit/gef4.mvc.tutorial

- https://github.com/tohosaku/gef4.mvc.tutorial
