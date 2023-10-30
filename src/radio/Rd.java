package radio;

public class Rd implements Interface {

    int volume;
    int estacao;
    String banda;
    boolean estado;

    public Rd(int volume, boolean estado) {
        this.volume = volume;
        this.estacao = 87;
        this.banda = "FM";
        this.estado = estado;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getEstacao() {
        return this.estacao;
    }

    public String getBanda() {
        return this.banda;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setEstacao(int estacao) {
        this.estacao = estacao;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public void play() {
        if (getEstado() == false) {
            setEstado(true);
            System.out.println("Rádio ligado");
        } else {
            System.out.println("O rádio ja esta ligado");
        }
    }

    @Override
    public void pause() {
        if (getEstado() == true) {
            setEstado(false);
            System.out.println("Rádio desligado");
        } else {
            System.out.println("O rádio ja esta desligado");
        }
    }

    @Override
    public void estado() {
        if (getEstado() == true) {
            System.out.println("O rádio esta ligado");
        } else {
            System.out.println("O rádio esta desligado");
        }
    }

    @Override
    public void dislAumenta() {
        if (getEstado() == true) {
            if ("FM".equals(getBanda())) {
                if (getEstacao() < 108) {
                    setEstacao((int) (getEstacao() + 3));
                    System.out.println("Estação FM: " + getEstacao() + "MHz");
                } else {
                    System.out.println("Sem mais estações para aumentar");
                }
            } else {
                if (getEstacao() < 1710) {
                    setEstacao((int) (getEstacao() + 10));
                    System.out.println("Estação AM: " + getEstacao() + "kHz");
                } else {
                    System.out.println("Sem mais estações para aumentar");
                }
            }
        } else {
            System.out.println("O rádio infelizmente esta desligado");
        }
    }

    @Override
    public void dislDiminui() {
        if (getEstado() == true) {
            if ("FM".equals(getBanda())) {
                if (getEstacao() > 87) {
                    setEstacao((int) (getEstacao() - 3));
                    System.out.println("Estação FM: " + getEstacao() + "MHz");
                } else {
                    System.out.println("Sem mais estações para diminuir");
                }
            } else {
                if (getEstacao() > 520) {
                    setEstacao((int) (getEstacao() - 10));
                    System.out.println("Estação AM: " + getEstacao() + "kHz");
                } else {
                    System.out.println("Sem mais estações para diminuir");
                }
            }
        } else {
            System.out.println("O rádio infelizmente esta desligado");
        }
    }

    @Override
    public void volumeAumenta() {
        if (getEstado() == true) {
            if (getVolume() != 50) {
                setVolume(getVolume() + 5);
                System.out.println("Volume: " + getVolume());
            } else {
                System.out.println("Volume ja esta no máximo permitido pelo Rádio");
            }
        } else {
            System.out.println("O rádio infelizmente esta desligado");
        }
    }

    @Override
    public void volumeDiminui() {
        if (getEstado() == true) {
            if (getVolume() != 0) {
                setVolume(getVolume() - 5);
                System.out.println("Volume: " + getVolume());
            } else {
                System.out.println("Volume ja esta no mínimo permitido pelo Rádio");
            }
        } else {
            System.out.println("O rádio infelizmente esta desligado");
        }
    }

    int lastFM = 87;
    int lastAM = 520;

    @Override
    public void faixaSintonia() {
        if (getBanda().equals("FM")) {
            lastFM = getEstacao();
            setBanda("AM");
            setEstacao(lastAM);
            System.out.println("Faixa setada para AM");
            System.out.println("Estação: " + getEstacao()+"kHz");
        } else {
            lastAM = getEstacao();
            setBanda("FM");
            setEstacao(lastFM);
            System.out.println("Faixa setada para FM");
            System.out.println("Estação: " + getEstacao()+"MHz");
        }
    }
}
