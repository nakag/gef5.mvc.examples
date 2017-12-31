# Example 3
Move the model using the mouse.

This example has many points.

## model

Add a PropertyChangeSupport (or SimpleObjectProperty) to the model to notify the contentpart that the model has changed.
To migrate GEF3, I use PropertyChangeSupport.

## Parts

- Add a PropertyChangeListener(or ChangeListener) to the contentpart so that it can receive that the model has changed.

- Implements ITransformableContentPart.

## MvcFxModule

- Override bindAbstractContentPartAdapters.
- Add adapter settings to contentpart.