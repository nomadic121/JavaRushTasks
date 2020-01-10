package com.javarush.task.task14.task1409;

interface Bridge{
    final int water = 285;
    final int Suspend = 3987;
    default int getCarsCount(){
        return this.getClass().hashCode();
    }
}