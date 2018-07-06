package nmu.devilliers;

import javafx.util.Pair;

import java.util.ArrayList;

public abstract class Leaf
{
    public final Long maxNumberBytes = 536870912L; //512MB is the absolute maximum size of a given leaf
    public abstract Boolean equalsTo(Leaf obj1);
    public abstract Integer compareTo(Leaf obj1);
    public abstract ArrayList<Pair<String, String>> toArraylistPairForSending();
    public abstract String toString();
    public abstract String Type();
    public abstract String PrimaryKeyOfCreator();



}
