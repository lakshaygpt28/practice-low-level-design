package DesignPatterns.FacadePattern.facade;

import DesignPatterns.FacadePattern.mediaConversionLibrary.AudioMixer;
import DesignPatterns.FacadePattern.mediaConversionLibrary.BitrateReader;
import DesignPatterns.FacadePattern.mediaConversionLibrary.Codec;
import DesignPatterns.FacadePattern.mediaConversionLibrary.CodecFactory;
import DesignPatterns.FacadePattern.mediaConversionLibrary.MPEG4CompressionCodec;
import DesignPatterns.FacadePattern.mediaConversionLibrary.OggCompressionCodec;
import DesignPatterns.FacadePattern.mediaConversionLibrary.VideoFile;

import java.io.File;

public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec detinationCodec;
        if (format.equals("mp4")) {
            detinationCodec = new MPEG4CompressionCodec();
        } else {
            detinationCodec = new OggCompressionCodec();
        }
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, detinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}
