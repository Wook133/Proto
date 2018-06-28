package nmu.devilliers;

import java.util.ArrayList;

public class TestingClass {
    public static void main(String[] args)
    {
        ArrayList<String> HashFunctions = new ArrayList<String>();
        HashFunctions.add("SHA-1");

        MerkleTree mt = new MerkleTree();

        for (int i = 0; i <= 15; i++)
        {
            mt.addHashes(String.valueOf(i));
        }

        mt.buildTree(HashFunctions.get(0));
        System.out.println("I am a Merkle Root: "+ mt.getMerkleRoot());
        System.out.println("Size: " + mt.lengthList());

        MerkleTree mt2 = new MerkleTree();

        for (int i = 3; i <= 18; i++)
        {
            mt2.addHashes(String.valueOf(i));
        }

        mt2.buildTree(HashFunctions.get(0));

        mt2.setMerkleRoot("c386a00f6aebf8c25a97c8ea8fbd90d1a256c408");
        System.out.println("I am a Merkle Root: "+ mt2.getMerkleRoot());
        System.out.println("Size: " + mt2.lengthList());

        System.out.println("Equal Trees: " + mt.compareTrees(mt2));

    }
}
