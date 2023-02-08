public enum Embalagem{
    GRANDE(20),
    MEDIA(10),
    PEQUENA(5);

    private double limitePacotes;

    Embalagem(double limitePacotes) {
        this.limitePacotes = limitePacotes;
    }

    public double getLimitePacotes() {
        return limitePacotes;
    }
}