/**
 * Facade Pattern
 *   복잡한 lib들을 Facade 클래스로 간단하게 사용가능한 API 제공
 *   1. Facade class로 직관적인 method 제공
 *   2. client는 Facade class 말고는 접근x (package로 만들고, default class로 만들어 접근제한을 걸어버리자)
 */

class CPU {
    public void freeze() { 
        System.out.println("CPU::freeze()\n"); 
    }

    public void jump(long bootAddress) { 
        System.out.println("CPU::jump(bootAddress)");
        System.out.println("addr: " + bootAddress + "\n"); 
    }

    public void execute() { 
        System.out.println("CPU::excute()"); 
    }
}

class Memory {
    public void load(long bootAddress, byte[] data) { 
        System.out.println("Memory::load(bootAddress, data)");
        System.out.println("addr: " + bootAddress + "\n");
    }
}

class HardDrive {
    public byte[] read(long bootSector, int sectorSize) {
        System.out.println("HardDrive::read(bootSector, sectorSize)");
        System.out.println("sector: " + bootSector + ", size: " + sectorSize + "\n");

        return new byte[] {};
    }
}

/* Façade */
class Computer {
    final long BOOT_ADDRESS = 102L;
    final long BOOT_SECTOR = 204L;
    final int SECTOR_SIZE = 1000;

    public void startComputer() {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();

        cpu.freeze();
        memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
        cpu.jump(BOOT_ADDRESS);
        cpu.execute();
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startComputer();
    }
}
