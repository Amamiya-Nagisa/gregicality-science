package gregicality.science.api.particle;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;

public class Particle {

    protected final String name;
    protected final float mass;
    protected final double electricCharge;
    protected final boolean coloured;
    protected final boolean weaklyCharged;
    protected final float spin;
    protected final int parity;

    protected Particle antiparticle;

    protected ArrayList<ParticleStack> components;

    public Particle(String name, float mass, double electricCharge, boolean coloured, boolean weaklyCharged, float spin, int parity){
        this.name = name;
        this.mass = mass;
        this.electricCharge = electricCharge;
        this.coloured = coloured;
        this.weaklyCharged = weaklyCharged;
        this.spin = spin;
        this.parity = parity;
    }

    public String getName() {
        return name;
    }

    public float getMass() {
        return mass;
    }

    public double getElectricCharge() {
        return electricCharge;
    }

    public boolean isColoured() {
        return coloured;
    }

    public boolean isWeaklyCharged() {
        return weaklyCharged;
    }

    public float getSpin() {
        return spin;
    }

    public void setAntiparticle(Particle antiparticle){
        this.antiparticle = antiparticle;
    }

    public boolean hasAntiparticle(){
        return (antiparticle != null);
    }

    @Nullable
    public Particle getAntiparticle(){
        return antiparticle;
    }

    public int getParity(){
        return parity;
    }

    protected void setComponents(ArrayList<ParticleStack> components) {
        this.components = components;
    }

    protected void addComponent(ParticleStack particleStack){
        this.components.add(particleStack);
    }

    public Particle addComponent(Particle particle, int amount){
        this.addComponent(new ParticleStack(particle, amount));
        return this;
    }

    @Nullable
    public ArrayList<ParticleStack> getComponents(){
        return components;
    }

    public ParticleStack getComponent(int i){
        return components.get(i);
    }

    public boolean isComposite(){
        return components.size() != 0;
    }

    public boolean isFundamental(){
        return !isComposite();
    }
}
