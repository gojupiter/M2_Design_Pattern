package edu.sa.td4.Question2;


public interface ArmyVisitor {
    public void visit(Group g);
    public void visit(ProxyHorsemen horsemen);
    public void visit(ProxyInfantrymen infantrymen);
    public void visit(Horsemen horsemen);
    public void visit(Infantrymen infantrymen);
}
